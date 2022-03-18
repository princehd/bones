import React, { useState, useRef, useEffect } from "react";

import Sidebar from "./Sidebar";
import Aside2 from "./Aside2";
import "./Main.css";

let bool = false;

function Main({patient_info}) {
    const canvasRef = useRef(null); // 캔버스 참조
    const contextRef = useRef(null);

    const [src, setSrc] = useState("");
    const [ctx, setCtx] = useState("");
    const [isDrawing, setIsDrawing] = useState(false);

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

                contextRef.current = context;
                setCtx(contextRef.current);
            };
        };
        urlReader.readAsDataURL(uploadedImage);
    };

    const finishDrawing = ({ nativeEvent }) => {
        //console.log(bool);
        setIsDrawing(bool);
        const { offsetX, offsetY } = nativeEvent;

        ctx.beginPath();
        ctx.moveTo(offsetX, offsetY);
        ctx.arc(offsetX, offsetY, 5, 0, Math.PI * 2, false);
        ctx.fill();
        ctx.stroke();
        ctx.closePath();
    };

    const startDrawing2 = () => {
        bool = true;
    };

    return (
        <main>
            <Sidebar onClickUploadButton={onClickUploadButton} startDrawing2={startDrawing2} />

            <section className="canvas_area">
                <canvas src={src} id="boneCanvas" className="boneCanvas" ref={canvasRef} onMouseUp={finishDrawing} onMouseLeave={finishDrawing}></canvas>
                <div id="mouseXY"></div>
            </section>
            <Aside2 patient_info={patient_info}/>
        </main>
    );
}

export default Main;
