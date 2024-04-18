import axios from 'axios';

const EMPLOYEE_GET_ALL_API="http://localhost:8081/api/v1/employees";

export const listEmployees=()=>{
    return axios.get(EMPLOYEE_GET_ALL_API);
}