import axios from 'axios';

const EMPLOYEE_GET_ALL_API="http://localhost:8081/api/v1/employees";

export const listEmployees=()=>{
    return axios.get(EMPLOYEE_GET_ALL_API);
}

export const createEmployee=(employee)=>{
    return axios.post(EMPLOYEE_GET_ALL_API, employee);
}

export const getEmployee=(employeeId)=>{
    return axios.get(EMPLOYEE_GET_ALL_API +'/'+ employeeId);
}

export const updateEmployee=(employeeId, employee) =>{
    return axios.put(EMPLOYEE_GET_ALL_API +'/'+ employeeId, employee);
}

export const deleteEmployee=(employeeId)=>{
    return axios.delete(EMPLOYEE_GET_ALL_API +'/'+ employeeId);
}