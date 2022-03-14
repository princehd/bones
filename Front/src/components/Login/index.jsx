import React from "react";
import "./index.css";

function Login() {
    return (
        <div>
            <main className="login_area">
                <div className="login_box">
                    <div className="login__box">
                        <div className="login_inner">
                            <h1>ChiroBones</h1>
                            <form action="" method="">
                                <div id="loginId" className="login_form">
                                    <input type="text" name="id" id="id" className="loginBtn_id" aria-label="이메일" autocapitalize="off" required />
                                    <label for="id">id@example.com</label>
                                </div>
                                <div id="loginPw" className="login_form">
                                    <input type="password" name="pw" id="pw" className="loginBtn_pw" aria-label="비밀번호" autocapitalize="off" required />
                                    <label for="pw">password</label>
                                </div>
                                <span className="loginBtn_area">
                                    <button type="submit" id="loginBtn_join" className="login_btns" aria-label="가입 버튼" onclick="location.href='join.html'">
                                        Sign up
                                    </button>
                                    <button type="submit" formmethod="post" id="loginBtn_login" className="login_btns" aria-label="로그인 버튼" onclick="location.href='index.html'">
                                        Sign in
                                    </button>
                                </span>
                            </form>
                        </div>
                    </div>
                </div>
            </main>
        </div>
    );
}

export default Login;
