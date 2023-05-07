package team.jit.qa.meeting;

import static com.codeborne.selenide.Selenide.open;

public abstract class PageBase {

  abstract String endpointAddress();

  public void openPage() {
    open(endpointAddress());
  }
}
