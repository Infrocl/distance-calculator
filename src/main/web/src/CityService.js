import axios from 'axios';

const CITIES_BASE_URL = 'http://localhost:8080/cities/all';

class CitySerice{

    getCities(){
        return axios.get(CITIES_BASE_URL);
    }
}

export default new CitySerice();