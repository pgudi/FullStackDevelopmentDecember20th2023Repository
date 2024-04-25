import React from 'react'
import { Link } from 'react-router-dom'
import { useNavigate } from 'react-router-dom'
const HeaderComponent = () => {

    const navigate = useNavigate();
    const handleLogout=()=>{
        navigate('/');
    }
    return (
        <div>
            <nav className="navbar navbar-expand-lg bg-primary navbar-dark">
                <div className="container-fluid">
                    <Link to={'/home'} className="navbar-brand text-white">GenTech Academy</Link>
                    <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                        <span className="navbar-toggler-icon"></span>
                    </button>
                    <div className="collapse navbar-collapse" id="navbarNav">
                        <ul className="navbar-nav">
                            <li className="nav-item">
                                <Link to={'/home'} className="nav-link text-white">Home</Link>
                            </li>
                            <li className="nav-item">
                                <Link to={'/about'} className="nav-link text-white">About Us</Link>
                            </li>
                            <li className="nav-item">
                                <Link to={'/courses'} className="nav-link text-white">Courses</Link>
                            </li>
                            <li className="nav-item">
                                <Link to={'/contact'} className="nav-link text-white">Contact Us</Link>
                            </li>
                        </ul>
                    </div>
                    <div>
                    <button type="button" class="btn btn-outline-info text-white" onClick={handleLogout}>Logout</button>
                    </div>
                </div>
            </nav>
        </div>
    )
}

export default HeaderComponent