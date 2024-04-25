import React, { useState } from 'react'
import {useNavigate} from 'react-router-dom'
const LoginPage = () => {
    const [userName, setUserName] = useState('');
    const [password, setPassword] = useState('');

    const navigate = useNavigate();
    const handleUserName =(e)=>{
        setUserName(e.target.value);
    }

    const handlePassword=(e)=>{
        setPassword(e.target.value);
    }

    const handleSignIn=() =>{
        if(userName== 'admin' && password=='welcome')
        {
            navigate('/home')
        }
        else{
            navigate('/')
        }
    }
    const handleCancel=()=>{
        navigate('/')
    }
  return (
    <div>
        <div className='container mt-5'>
            <div className='row justify-content-center'>
                <div className='col-md-6'>
                    <h2 className='text-center'>Login</h2>
                    <div className='card'>
                        <div className='card-body'>
                            <form>
                                <div className='form-group'>
                                    <label className='form-label'>User Name</label>
                                    <input 
                                        type="text"
                                        placeholder='Enter User Name'
                                        name='userName'
                                        value={userName}
                                        className='form-control'
                                        onChange={handleUserName}
                                    ></input>
                                </div>
                                <div className='form-group'>
                                    <label className='form-label'>Password</label>
                                    <input 
                                        type="password"
                                        placeholder='Enter Password'
                                        name='password'
                                        value={password}
                                        className='form-control'
                                        onChange={handlePassword}
                                    ></input>
                                </div>
                                <div>
                                    <button className='btn btn-primary me-2' onClick={handleSignIn}>SignIn</button>
                                    <button className='btn btn-primary' onClick={handleCancel}>Cancel</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
  )
}

export default LoginPage