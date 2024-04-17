const Conditional1 = () => {
    let isMorning = false;
    let message;

    if (isMorning == true) {
        message = <h3>Good Morning to Every One!!</h3>
    }
    else {
        message = <h3>Good Evening to Every One!!</h3>
    }

    return (
        <div>{message}</div>
    )
}

export default Conditional1