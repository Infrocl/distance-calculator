import React, {useState, useEffect} from 'react'
import CitySerice from './CityService';

function CityComponent() {

    const [cities, setCities] = useState([])

    useEffect(() => {
        getCities()
    }, [])

    const getCities = () => {

        CitySerice.getCities().then((response) => {
            setCities(response.data)
            console.log(response.data);
        });
    };

    return (
        <div className = "container">
            
            <h1 className = "text-center"> Cities List</h1>

            <table className = "table table-striped">
                <thead>
                    <tr>
                        <th> City Id</th>
                        <th> City Name</th>
                    </tr>

                </thead>
                <tbody>
                    {
                        Object.keys(cities).map(
                                key =>
                                <tr>
                                    <td> {key}</td>
                                    <td> {cities[key]}</td>
                                </tr>

                        )
                    }

                </tbody>


            </table>

        </div>
    )
}

export default CityComponent