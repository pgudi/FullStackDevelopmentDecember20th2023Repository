const Flower=(props)=>{
    return(
        <div>
            <li>{props.details.name} {props.details.color} ${props.details.price}</li>
        </div>
    )
}

export default Flower;