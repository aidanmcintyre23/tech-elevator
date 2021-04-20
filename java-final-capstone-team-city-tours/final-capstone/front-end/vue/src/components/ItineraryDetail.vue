<template>
    <div :style="image" class="background-image">
    <div class="ItineraryDetail">
        <h1 style="margin-top: 100px; font-family: Garamond;">{{itinerary.startingPoint}}</h1>
        <h2 style="font-family: Garamond;">{{itinerary.date}}</h2>
        <button class="center" v-on:click="itineraryCreated = !itineraryCreated">Edit</button>
        
        
        <form class="center" v-if="itineraryCreated" v-on:submit.prevent="editItinerary">
            <input type="text" id="startingPoint" name="startingPoint" v-model="itinerary.startingPoint" placeholder="Itinerary Name"><br>
            <input type="text" id="date" name="date" v-model="itinerary.date" placeholder="Date of Travel"><br>
            <button type="submit">Edit Itinerary </button>
        </form>
        
        <!-- Loop through destinations array and display names after search -->
        <ul>        
            <li class="center" v-for="destination in destinations" v-bind:key="destination.destinationId">
                <button v-on:click="removeFromItinerary(destination)">Remove From Itinerary</button>
                <router-link :to="{ name: 'DestinationDetail', params: { id: destination.destinationId}}" class="destinationDetail">
                    {{ destination.name }}
                </router-link>
            </li>
        </ul>
        
       <button class="center" v-on:click="deleteItinerary">Delete</button>     
       <GoogleMap class="map" :destinations="destinations"/>
    </div>
    </div>
</template>

<script>
import ItineraryServices from '../services/ItineraryServices.js'
import GoogleMap from '../components/GoogleMap.vue'

export default {
    components: {
    GoogleMap
  },
    name: 'Home',
    created() {
        ItineraryServices.getItineraryByItineraryId(this.$route.params.id).then(response => {
            this.itinerary = response.data;
        });
        ItineraryServices.viewDestinationsByItineraryId(this.$route.params.id).then(response => {
            this.destinations = response.data;
        });
    },
    data() {
        return {
            itinerary: [],
            destinations: [],
            itineraryCreated: false,
            image: { backgroundImage: "url(https://www.thisiscleveland.com/getattachment/5e023d1b-903e-44c8-ac13-f3c3faafcff3/Cleveland-Ohio-in-the-early-evening.jpg)"}
        }
    },
    methods: {
        deleteItinerary() {

            ItineraryServices.deleteItinerary(this.itinerary.itineraryId).then(() => {
                this.$router.push('/')
            })
        },
        editItinerary() {
            ItineraryServices.editItinerary(this.itinerary.startingPoint, this.itinerary.date, this.itinerary.itineraryId).then(() => {
                this.itineraryCreated = false;
            })
            
        },
        changeCreated() {
             if (this.itineraryCreated === true) {
                this.itineraryCreated = false;
            } else {
            this.itineraryCreated = true;
            }
        },
        removeFromItinerary(destination) {
            const index = this.destinations.indexOf(destination);
            this.destinations.splice(index, 1);
            ItineraryServices.deleteDestinationFromItinerary(destination.destinationId);
        }
    }
}
</script>

<style scoped>
h1{
    display: flex;
    justify-content: center;
    
}

h2 {
    display: flex;
    justify-content: center;
    color: white;
    margin-top: -35px;
    font-size:xx-large;
}

label {
    color: white;
    background-color:#206994;
}

.center {
    display: flex;
    justify-content: center;
   
}

.destinationDetail {
    display: flex;
    justify-content: center;
}

form.center {
    display: flex;
    align-items: center;
}

.delete {
    display: flex;
    margin-left: auto;
    margin-right: 20%;
    margin-top: 50px;
}

.edit {
    margin-left: 20%;

}
div.background-image {
        background-size: cover;
        background-repeat: no-repeat;
        height: 100%;
        padding-top: 10px;
    }

.map {
    margin-left: 5%;
    margin-right: 5%;
}

</style>
