import React from "react";
import Button from "react-bootstrap/Button";

function SignUp(){

    return(
        <div className="Login-form-container">
            <form className="Login-form">
                <div className="Login-form-content">
                    <h3 className="Login-form-title">Sign Up</h3>
                    <div className="form-group mt-3">
                        <label>Name</label>
                        <input
                            type="text"
                            className="form-control mt-1"
                            placeholder="e.g Jane Doe"
                        />
                    </div>
                    <div className="form-group mt-3">
                        <label>Email address</label>
                        <input
                            type="email"
                            className="form-control mt-1"
                            placeholder="Email Address"
                        />
                    </div>
                    <div className="form-group mt-3">
                        <label>Password</label>
                        <input
                            type="password"
                            className="form-control mt-1"
                            placeholder="Password"
                        />
                    </div>
                    <div className="form-group mt-3">
                        <label>Address</label>
                        <input
                            type="text"
                            className="form-control mt-1"
                            placeholder="e.g Jane Doe"
                        />
                    </div>
                    <div className="form-group mt-3">
                        <label>Nickname</label>
                        <input
                            type="text"
                            className="form-control mt-1"
                            placeholder="Email Address"
                        />
                    </div>
                    <div className="form-group mt-3">
                        <label>phone</label>
                        <input
                            type="phone"
                            className="form-control mt-1"
                            placeholder="Password"
                        />
                    </div>
                    <div className="d-grid gap-2 mt-3">
                        <Button variant="primary" >Submit</Button>
                    </div>
                    <p className="already-have text-right mt-2">
                        Already registered? <a href="/Login">Sign In</a>
                    </p>
                </div>
            </form>
        </div>
    )
}

export default SignUp;