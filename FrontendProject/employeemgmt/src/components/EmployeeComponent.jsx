import { useEffect, useState } from "react";
import {useNavigate} from 'react-router-dom'
import { createEmployee, getEmployee, updateEmployee } from "../services/EmployeeServices";

import { useParams } from "react-router-dom";

const EmployeeComponent=()=>{
    const [employeeFirstName, setEmployeeFirstName] = useState('');
    const [employeeLastName, setEmployeeLastName] = useState('');
    const [jobName, setJobName] = useState('');
    const [emailId, setEmailId] = useState('');
    const [age, setAge] = useState(0);
    const [contactNumber, setContactNumber] = useState(0);
    const [salary, setSalary] = useState(0.0);
    const [departmentName, setDepartmentName] = useState('');
    const [cityName, setCityName] = useState('');
    const [address, setAddress] = useState('');

    const {id} = useParams();

    const navigate = useNavigate();

    const handleFirstName=(e)=>{
        setEmployeeFirstName(e.target.value);
    }

    const handleLastName=(e)=>{
        setEmployeeLastName(e.target.value);
    }

    const handleJobName=(e) =>{
        setJobName(e.target.value);
    }

    const handleEmail=(e)=>{
        setEmailId(e.target.value);
    }

    const handleAge=(e)=>{
        setAge(e.target.value);
    }

    const handleContactNumber=(e)=>{
        setContactNumber(e.target.value);
    }

    const handleSalary=(e)=>{
        setSalary(e.target.value);
    }

    const handleDepartment=(e)=>{
        setDepartmentName(e.target.value);
    }

    const handleCityName=(e)=>{
        setCityName(e.target.value);
    }
    const handleAddress=(e)=>{
        setAddress(e.target.value);
    }

    const navigateHome=()=>{
        navigate('/employees');
    }

    useEffect(() =>{
        getEmployee(id).then((response) =>{
            setEmployeeFirstName(response.data.employeeFirstName);
            setEmployeeLastName(response.data.employeeLastName);
            setJobName(response.data.jobName);
            setEmailId(response.data.emailId);
            setAge(response.data.age);
            setContactNumber(response.data.contactNumber);
            setSalary(response.data.salary);
            setDepartmentName(response.data.departmentName);
            setCityName(response.data.cityName);
            setAddress(response.data.address);

        }).catch(error =>{
            console.error(error)
        })
    },[id])

    const saveAndUpdateEmployee =(e)=>{
        e.preventDefault();
        const employee = {employeeFirstName, employeeLastName, jobName, emailId, age, contactNumber, salary, departmentName, cityName, address};
        console.log(employee);

        if(id){
            updateEmployee(id, employee).then((response) =>{
                console.log(response.data);
            })
        }
        else{
            createEmployee(employee).then((response) =>{
                console.log(response.data);
            })
        }
        
        navigate('/employees');
    }

    function showPageHeading(){
        if(id)
        {
            return <h4 className="text-center">Update Employee</h4>
        }
        else{
            return <h4 className="text-center">Create Employee</h4>
        }
    }
    return(
        <div>
            <div className="container-fluid">
                <div className="row justify-content-center">
                    <div className="col-md-6">
                        {
                            showPageHeading()
                        }
                            <form>
                                <div className="form-group">
                                    <label className="form-label">First Name:</label>
                                    <input
                                        type="text"
                                        placeholder="Enter First Name"
                                        name="employeeFirstName"
                                        value={employeeFirstName}
                                        className="form-control"
                                        onChange={handleFirstName}
                                    ></input>
                                </div>
                                <div className="form-group">
                                    <label className="form-label">Last Name:</label>
                                    <input
                                        type="text"
                                        placeholder="Enter Last Name"
                                        name="employeeLastName"
                                        value={employeeLastName}
                                        className="form-control"
                                        onChange={handleLastName}
                                    ></input>
                                </div>
                                <div className="form-group">
                                    <label className="form-label">Job Name:</label>
                                    <input
                                        type="text"
                                        placeholder="Enter Job Name"
                                        name="jobName"
                                        value={jobName}
                                        className="form-control"
                                        onChange={handleJobName}
                                    ></input>
                                </div>
                                <div className="form-group">
                                    <label className="form-label">EMail Id:</label>
                                    <input
                                        type="text"
                                        placeholder="Enter Email Id"
                                        name="emailId"
                                        value={emailId}
                                        className="form-control"
                                        onChange={handleEmail}
                                    ></input>
                                </div>
                                <div className="form-group">
                                    <label className="form-label">Age:</label>
                                    <input
                                        type="text"
                                        placeholder="Enter Age"
                                        name="age"
                                        value={age}
                                        className="form-control"
                                        onChange={handleAge}
                                    ></input>
                                </div>

                                <div className="form-group">
                                    <label className="form-label">Contact Number:</label>
                                    <input
                                        type="text"
                                        placeholder="Enter Contact Number"
                                        name="contactNumber"
                                        value={contactNumber}
                                        className="form-control"
                                        onChange={handleContactNumber}
                                    ></input>
                                </div>

                                <div className="form-group">
                                    <label className="form-label">Salary:</label>
                                    <input
                                        type="text"
                                        placeholder="Enter Salary"
                                        name="salary"
                                        value={salary}
                                        className="form-control"
                                        onChange={handleSalary}
                                    ></input>
                                </div>

                                <div className="form-group">
                                    <label className="form-label">Department Name:</label>
                                    <input
                                        type="text"
                                        placeholder="Enter Department Name"
                                        name="departmentName"
                                        value={departmentName}
                                        className="form-control"
                                        onChange={handleDepartment}
                                    ></input>
                                </div>

                                <div className="form-group">
                                    <label className="form-label">City Name:</label>
                                    <input
                                        type="text"
                                        placeholder="Enter City Name"
                                        name="cityName"
                                        value={cityName}
                                        className="form-control"
                                        onChange={handleCityName}
                                    ></input>
                                </div>

                                <div className="form-group">
                                    <label className="form-label">Address:</label>
                                    <input
                                        type="text"
                                        placeholder="Enter Address"
                                        name="address"
                                        value={address}
                                        className="form-control"
                                        onChange={handleAddress}
                                    ></input>
                                </div>
                                <div className="mb-5 mt-2">
                                    <button className="bg-primary text-white" onClick={saveAndUpdateEmployee}>Save</button>
                                    <button onClick={navigateHome} className="ms-4 bg-primary text-white">Cancel</button>
                                </div>
                            </form>
                    </div>
                </div>
            </div>
        </div>
    )
}

export default EmployeeComponent;