const Conditional2=()=>{
    let isEligible=true;

    let message;
    message=isEligible?<h3>Person clears UPSC Exam</h3>:<h3>Person does not clear UPSC Exam</h3>
    return(
        <div>
            {message}
        </div>
    )
}

export default Conditional2;