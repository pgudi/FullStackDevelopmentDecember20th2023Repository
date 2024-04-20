import { useEffect, useState } from "react";
import { deleteEmployee, listEmployees } from "../services/EmployeeServices";
import {useNavigate} from 'react-router-dom'

const ListEmployeeComponent=()=>{
    const [employees, SetEmployees] = useState([]);
    const navigate=useNavigate();
    

    useEffect(() =>{
        listEmployees().then((employee) =>{
            SetEmployees(employee.data);
            console.log(employee.data);
        })
    },[])
    const createEmployee=(id)=>{
        navigate('/create-employee');
    }

    const updateEmployee=(id)=>{
        navigate(`/edit-employee/${id}`);
    }
    
    const removeEmployee=(id) =>{
        deleteEmployee(id).then((response) =>{
            console.log(response.data)
        })
    }
    return(
        <div>
            <h3 className="text-center mt-auto">Display Employees</h3>
            <button className="btn btn-primary mb-2" onClick={createEmployee}>Create Employee</button>
            <table className="table table-striped table-bordered">
                <thead>
                    <tr>
                        <th>EmployeeId</th>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Job Name</th>
                        <th>Email Id</th>
                        <th>Age</th>
                        <th>ContactNo</th>
                        <th>Salary</th>
                        <th>Department</th>
                        <th>City Name</th>
                        <th>Address</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    {
                     
                     employees.map(employee =>(
                            <tr key={employee.id}>
                            <td>{employee.id}</td>
                            <td>{employee.employeeFirstName}</td>
                            <td>{employee.employeeLastName}</td>
                            <td>{employee.jobName}</td>
                            <td>{employee.emailId}</td>
                            <td>{employee.age}</td>
                            <td>{employee.contactNumber}</td>
                            <td>{employee.salary}</td>
                            <td>{employee.departmentName}</td>
                            <td>{employee.cityName}</td>
                            <td>{employee.address}</td>
                            <td>
                                <button className="btn btn-primary" onClick={() => updateEmployee(employee.id)}>Update</button>
                                <button className="btn btn-danger" onClick={() => removeEmployee(employee.id)}>Delete</button>
                            </td>
                            </tr>
                        ))
                     
                    }
                </tbody>
            </table>
        </div>
    )
}

export default ListEmployeeComponent;