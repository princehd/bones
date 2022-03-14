import React, { useState } from "react";
import FirstTab_01input from "./TabMenu2/FirstTab_01input";
import FirstTab_02diagnosis from "./TabMenu2/FirstTab_02diagnosis";
import FirstTab_03info from "./TabMenu2/FirstTab_03info";

import SecondTab_01list from "./TabMenu2/SecondTab_01list";
import SecondTab_02create from "./TabMenu2/SecondTab_02create";
import SecondTab_03detail from "./TabMenu2/SecondTab_03detail";
import "./Aside.css";

function Aside2() {
    const [Tab, setTab] = useState(true);
    return (
      <aside className="aside">
      <div id="asideAiBtn" className="aside_btn">
          <button id="btnAI" className="btn_ai" type="button">
              ChiroBones
          </button>
      </div>
      
      <div id="tabMenu" className="tab_menu">
         { Tab ? <MinutesToHours /> : null}
          <TabContainer index={index} updateIndex={this.updateIndex}>
              <TabMenu title="Registration" className="list_Box">
                  <Registration />
              </TabMenu>
              <TabMenu title="Diagnosis" className="list_Box">
                  <Examination />
              </TabMenu>
              <TabMenu title="Info" className="list_Box">
                  <Patient />
              </TabMenu>
              <TabMenu title="Sharing" className="list_Box">
                  <Platform />
              </TabMenu>
          </TabContainer>
      </div>
  </aside>
    );
}

export default Aside2;
