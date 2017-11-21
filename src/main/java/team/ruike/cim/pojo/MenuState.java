package team.ruike.cim.pojo;


import java.io.Serializable;

public class MenuState implements Serializable {

  private static final long serialVersionUID = 3179068846309159854L;
  private Integer menuStateId;
  private Integer menuStateName;
  private Integer status;


  public Integer getMenuStateId() {
    return menuStateId;
  }

  public void setMenuStateId(Integer menuStateId) {
    this.menuStateId = menuStateId;
  }


  public Integer getMenuStateName() {
    return menuStateName;
  }

  public void setMenuStateName(Integer menuStateName) {
    this.menuStateName = menuStateName;
  }


  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

}
