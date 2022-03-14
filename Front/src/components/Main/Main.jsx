import React, { useState, useRef, useEffect } from "react";
import Sidebar from "./Sidebar";
import Aside from "./Aside";
import "./Main.css";

let bool = false;

function Main() {
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

    const startDrawing = () => {
        setIsDrawing(bool);
        console.log(bool);
    };

    const finishDrawing = () => {
        setIsDrawing(false);
    };

    const drawing = ({ nativeEvent }) => {
        const { offsetX, offsetY } = nativeEvent;
        if (ctx) {
            if (!isDrawing) {
                ctx.beginPath();
                ctx.moveTo(offsetX, offsetY);
            } else {
                ctx.lineTo(offsetX, offsetY);
                ctx.stroke();
            }
        }
    };

    const startDrawing2 = () => {
        bool = true;
        console.log(1);
    };

    return (
        <main>
            <Sidebar onClickUploadButton={onClickUploadButton} startDrawing2={startDrawing2} />
            <section className="canvas_area">
                <canvas
                    src={src}
                    id="boneCanvas"
                    className="boneCanvas"
                    ref={canvasRef}
                    onMouseDown={startDrawing}
                    onMouseUp={finishDrawing}
                    onMouseMove={drawing}
                    onMouseLeave={finishDrawing}
                ></canvas>
                <div id="mouseXY"></div>
            </section>
            <Aside />
        </main>
    );
}

export default Main;
