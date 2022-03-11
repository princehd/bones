import React, { Component } from "react";
import TabContainer from "./TabMenu/TabContainer";
import TabMenu from "./TabMenu/TabMenu";
import Registration from "./TabMenu/Registration";
import Examination from "./TabMenu/Examination";
import Patient from "./TabMenu/Patient";
import Platform from "./TabMenu/Platform";

export default class Aside extends Component {
    constructor(props) {
        super(props);
        this.state = {
            index: 0,
        };
    }

    updateIndex = (index) => {
        this.setState({ index });
    };

    render() {
        const { index } = this.state;

        return (
            <div>
                <aside className="aside">
                    <div id="asideAiBtn" className="aside_btn">
                        <button id="btnAI" className="btn_ai" type="button">
                            ChiroBones
                        </button>
                    </div>
                    <div id="tabMenu" className="tab_menu">
                        <TabContainer index={index} updateIndex={this.updateIndex} className="tab_btn">
                            <TabMenu title="환자 등록" className="listBox">
                                <Registration />
                            </TabMenu>
                            <TabMenu title="환자 진찰" className="listBox">
                                <Examination />
                            </TabMenu>
                            <TabMenu title="환자 정보" className="listBox">
                                <Patient />
                            </TabMenu>
                            <TabMenu title="공유 플랫폼" className="listBox">
                                <Platform />
                            </TabMenu>
                        </TabContainer>
                    </div>
                </aside>
            </div>
        );
    }
}
