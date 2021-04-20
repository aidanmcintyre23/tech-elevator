import axios from 'axios';
export default {

createItinerary(startingPoint, date) {
    return axios.post(`/createItinerary`, {
        startingPoint: startingPoint,
        date: date
    }); 
},

editItinerary(startingPoint, date, id) {
    return axios.put(`/updateItinerary/${id}`, {
        startingPoint: startingPoint,
        date: date
    })
},

//submitItinerary() { // finalize itinerary and generate route

//},

getItineraryByUserId(userId) {
    return axios.get(`/itineraryUser/${userId}`);
},

getItineraryByItineraryId(itineraryId) {
    return axios.get(`/viewItineraryById/${itineraryId}`);
},

deleteItinerary(itineraryId) {
    return axios.delete(`/deleteItinerary/${itineraryId}`)
},

addToItinerary(destinationId, itineraryId) {
    return axios.post(`/addItinerary/${destinationId}/${itineraryId}`)
},

viewDestinationsByItineraryId(itineraryId) {
    return axios.get(`/viewDestinationsByItineraryId/${itineraryId}`)
},

deleteDestinationFromItinerary(destinationId) {
    return axios.delete(`/deleteDestination/${destinationId}`)
}

}