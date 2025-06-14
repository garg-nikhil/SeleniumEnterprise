import influxdb_client
from sklearn.ensemble import IsolationForest
import pandas as pd

bucket = "mybucket"
org = "myorg"
token = "your-token"
url = "http://localhost:8086"

client = influxdb_client.InfluxDBClient(url=url, token=token, org=org)
query_api = client.query_api()

query = f'''
from(bucket:"{bucket}")
|> range(start: -1h)
|> filter(fn: (r) => r._measurement == "api_response_time")
|> keep(columns: ["_time", "_value"])
'''

result = query_api.query(query)
data = [(record.get_time(), record.get_value()) for table in result for record in table.records]

df = pd.DataFrame(data, columns=["time", "value"])
model = IsolationForest(contamination=0.1)
df["anomaly"] = model.fit_predict(df[["value"]])

print(df[df["anomaly"] == -1])  # Show anomalies
