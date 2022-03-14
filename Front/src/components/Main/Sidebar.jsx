import React from "react";
// import React, { useState, useEffect } from "react";
import "./Sidebar.css";

function Sidebar({ onClickUploadButton, startDrawing2 }) {
    const pointerStyle = {
        cursor: "pointer",
    };
    const uploaderStyle = {
        display: "none",
    };

    return (
        <aside className="sidebar">
            <ul id="leftIcon" className="sidebar_i">
                <li id="image_upload" className="menu_i">
                    <label htmlFor="uploaderSSSSSSSSSSSSSSSSSSSS" className="uploader">
                        <input type="file" id="uploader" style={uploaderStyle} accept="image/*" onChange={onClickUploadButton} />
                        <i className="material-icons" style={pointerStyle}>
                            add_photo_alternate
                        </i>
                    </label>
                </li>
                <li id="coordinate" className="menu_i">
                    <button className="i_btn">
                        <i className="material-icons">grid_4x4</i>
                    </button>
                </li>
                <li id="i_point" className="menu_i" onClick={startDrawing2}>
                    <button className="i_btn">
                        <i className="material-icons">adjust</i>
                    </button>
                </li>
                <li id="line" className="menu_i">
                    <button className="i_btn">
                        <i className="material-icons">straighten</i>
                    </button>
                </li>
                <li id="i_zoomin" className="menu_i">
                    <button className="i_btn">
                        <i className="material-icons">zoom_in</i>
                    </button>
                </li>
                <li id="i_zoomout" className="menu_i">
                    <button className="i_btn">
                        <i className="material-icons">zoom_out</i>
                    </button>
                </li>
                <li id="i_light" className="menu_i">
                    <button className="i_btn">
                        <i className="material-icons">lightbulb</i>
                    </button>
                </li>
            </ul>
        </aside>
    );
}

export default Sidebar;
