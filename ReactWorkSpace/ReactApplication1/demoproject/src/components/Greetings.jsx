const Greetings =(props)=>{
    const {details} = props;
    return(
        <div>
            <h3>Good Morning :{details.name} {details.city} {details.courses.join(' ')}</h3>
        </div>
    );
}
export default Greetings;