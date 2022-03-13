import React, { useState, useRef } from "react";
import Sidebar from "./Sidebar";
import Aside from "./Aside";
import "./Main.css";

function Main() {
    const [src, setSrc] = useState("");
    const canvasRef = useRef(null); // 캔버스 참조
    const image = new Image();
    const urlReader = new FileReader();
    const onClickUploadButton = ({ target }) => {
        if (!target.files.length) {
            return;
        }
        const uploadedImage = target.files[0];
        urlReader.onload = ({ target: { result: imageUrl } }) => {
            image.src = imageUrl;
            image.onload = () => {
                if (!canvasRef || !canvasRef.current) {
                    return;
                }

                const canvas = canvasRef.current;
                const context = canvas.getContext("2d");
                canvas.width = image.width;
                canvas.height = image.height;
                context.drawImage(image, 0, 0);
                setSrc(canvas.toDataURL());
            };
        };
        urlReader.readAsDataURL(uploadedImage);
    };

    return (
        <main>
            <Sidebar onClickUploadButton={onClickUploadButton} />
            <section className="canvas_area">
                <canvas src={src} id="boneCanvas" className="boneCanvas" ref={canvasRef}></canvas>
                <div id="mouseXY"></div>
            </section>
            <Aside />
        </main>
    );
}

export default Main;
