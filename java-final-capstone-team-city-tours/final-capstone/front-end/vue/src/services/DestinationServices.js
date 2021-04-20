/**************************************************************************************
* This file is provided for you to use for any Application services you may create
*
*  If you would prefer a file with a different name for your services, 
*     simply create one 
***************************************************************************************/
import axios from 'axios';

//const destinationAPI = axios.create({   // destinationAPI is the object that will make API calls
//    baseURL: "http://localhost:8080"                       // API server
                                        // Using our database for destinations
                                        // Using Google API for directions
//});

export default {
    // This connects to the controllers in Java
    getADestination(id) {
        return axios.get(`/destinations/${id}`);
    },

    getDestinations() {
        return axios.get('/destinations');
    },

    getDestinationByName(name) {
        console.log(`getDestinationByName: ${name}`)
        return axios.get(`/destinations?name=${name}`)
    },

    getDestinationByZip(zip) {
        return axios.get(`/destinations?zipcode=${zip}`)
    },

    getDestinationByVenueType(venuetype) {
        return axios.get(`/destinations?type=${venuetype}`)
    },
    
    getDestinationHours(id) {
        return axios.get(`/hours/${id}`)
    },

    getByDay(name) {
        return axios.get(`/dayOfWeek/${name}`)
    }
}