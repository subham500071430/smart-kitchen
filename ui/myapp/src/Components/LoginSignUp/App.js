import React, { useState } from 'react';
import Login from './Login';
import Signup from './Signup';
import Menu from '../Menu/FoodMenu';

function AuthPage() {
    const [isLoggedIn, setIsLoggedIn] = useState(false);
    const [isSignup, setIsSignup] = useState(false);
    const [userRegistered, setUserRegistered] = useState(false);

    const handleLogin = (status) => {
        setIsLoggedIn(status);
    };

    const handleSignup = () => {
        setUserRegistered(true);
        setIsSignup(false);
    };

    const toggleAuth = () => {
        setIsSignup(!isSignup);
        setUserRegistered(false);
    };

    return (
        <div>
            {!isLoggedIn ? (
                isSignup ? (
                    <div>
                        <Signup onSignup={handleSignup} />
                        <p>Already have an account? <button onClick={toggleAuth}>Login</button></p>
                    </div>
                ) : (
                    <div>
                        <Login onLogin={handleLogin} />
                        <p>Don't have an account? <button onClick={toggleAuth}>Sign Up</button></p>
                        {userRegistered && <p>User registered! Please login.</p>}
                    </div>
                )
            ) : (
                <div>
                    <Menu />
                </div>
            )}
        </div>
    );
}

export default AuthPage;
