import Flower from "./Flower";

const Flowers =()=>{
    const flowers=[
        { "name":"Lotus","color":"Pink","price" :100},
        { "name":"Rose","color":"Red","price" :20},
        { "name":"Jasmine","color":"White","price" :30},
        { "name":"Sunflower","color":"Yellow","price" :40}
    ]

    return(
        <div>
            <ul>
                {
                    flowers.map((flower) =>(
                        <Flower details={flower} />
                    ))
                }
            </ul>
        </div>
    );
}
export default Flowers;