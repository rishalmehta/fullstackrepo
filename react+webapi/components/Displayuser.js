import { useEffect, useState } from 'react';
import axios from "axios";


const Displaydata = (props) => {
    let [apidata, setapidata] = useState([]);

    useEffect(
        () => {
            axios.get('http://localhost:5163/api/user')
                .then(response => { setapidata(response.data) });
        }
    )

    var tablerows=()=> apidata.map(obj=>{
            return (
                <tr>
                    <td>{obj.userid}</td>
                    <td>{obj.username}</td>
                    <td>{obj.course}</td>
                    <td>{obj.purchasedate}</td>
                </tr>
          )
          });

    return (
        <>
        <br></br>
        <table id="studenttable">
            <tbody>
            <tr>
                <td>Userid</td>
                <td>Username</td>
                <td>Courses</td>
                <td>PurchaseDate</td>
            </tr>           
            {tablerows()}
            </tbody>
        </table>
        </>
       
);
}
export default Displaydata;