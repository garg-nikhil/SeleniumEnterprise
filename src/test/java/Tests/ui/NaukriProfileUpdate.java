package Tests.ui;

import Base.BaseTests;
import Pages.NaukriPortal;
import org.testng.annotations.Test;

public class NaukriProfileUpdate extends BaseTests {

  @Test
  public void UpdateNaukriProfile() {
    NaukriPortal naukriPortal = new NaukriPortal();
    naukriPortal.launchAndUpdateNaukriPortal();
  }
}
