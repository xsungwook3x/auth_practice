import React from "react";
import Button from 'react-bootstrap/Button';
function Login(){
    return(
        <div className="Login-form-container">
        <form className="Login-form">
            <div className="Login-form-content">
                <h3 className="Login-form-title">Login</h3>
                <div className="form-group mt-3">
                    <label>Email address</label>
                    <input
                        type="email"
                        className="form-control mt-1"
                        placeholder="Enter email"
                    />
                </div>
                <div className="form-group mt-3">
                    <label>Password</label>
                    <input
                        type="password"
                        className="form-control mt-1"
                        placeholder="Enter password"
                    />
                </div>
                <div className="d-grid gap-2 mt-3">
                    <Button variant="primary">Submit</Button>
                </div>
                <p className="forgot-password text-right mt-2">
                    Forgot <a href="#">password?</a>
                </p>
                <p className="new-account text-right mt-2">
                    <a href="#">You don't have a account?</a>
                </p>
            </div>
        </form>
        </div>
    )
}

export default Login;