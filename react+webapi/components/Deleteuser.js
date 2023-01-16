import {useState} from 'react';
import axios from 'axios';

const senddata = (props)=>{
    const [userdata,setuserdata] = useState({userid:""});

    const deleteuser=(event)=>{
        event.preventDefault();
        axios.delete(`http://localhost:5163/api/user/${userdata.userid}`);
    }

    const handleChange=(event)=>{
        const {name,value}=event.target
        setuserdata({...userdata,[name]:value})
    }

    return(
        <>
        <br></br>
        <h3>
            Enter student's rollno to be deleted
        </h3>
        <form method="GET" onsubmit={deleteuser}>
            <input type="text" name="userid" onchange={handleChange} placeholder="userid"></input>
            <input type="submit" value="Delete"/>
        </form>
        </>
    );
}
export default senddata;