<template>
    <div class="DestinationDetail" v-if="!isLoading">
        <h1>{{destination.name}}</h1>
        <a :href="destination.website">Visit Website</a>
        <!-- drop-down up here that lists through user itineraries -->
        <button v-on:click="postToItinerary">Add to Itinerary</button>
          <select v-if="userItineraries.length > 0" name="oneOption" id="itineraryList" v-model="selectedItinerary">
          <option v-for="itinerary in userItineraries" :key="itinerary.itineraryId" :value="itinerary.itineraryId">{{itinerary.startingPoint}}</option>
          </select>

        <div class="rating">
            <!-- Thumbs up -->
        <div class="like grow"  v-on:click="thumbsUp">
            <i class="fa fa-thumbs-up fa-3x like" :class="{'active' : isLiked && isClicked}" aria-hidden="true" id="like"></i>
        </div>
             <!-- Thumbs down -->
  <div class="dislike grow" v-on:click="thumbsDown">
    <i class="fa fa-thumbs-down fa-3x like" aria-hidden="true" id="dislike" :class="{'active' : !isLiked && isClicked}"></i>
  </div>
        <div class="both">
        <h2>{{destination.description}}</h2>
        <div class="Hours" >
            <ul>
                <li v-for="anHour in destination.hours" :key="anHour.hourId"> 
            <h3>{{anHour.dayOfWeek}}: 
                {{anHour.open}} -
                {{anHour.close}}  

           </h3>
                </li>
            </ul>
            

        </div>
        <img :src="destination.image" alt="Landmark Image" class="center">
    </div>
    </div>
    </div>
</template>

<script>
import DestinationServices from '../services/DestinationServices'
import ItineraryServices from '../services/ItineraryServices'


export default {
    created() {


        
        DestinationServices.getADestination(this.$route.params.id).then(response => {
            this.destination = response.data[0]
            console.log(this.destination)

            DestinationServices.getDestinationHours(this.$route.params.id).then(res => {
                this.destination.hours = res.data
               
                console.log(this.destination)
        
                ItineraryServices.getItineraryByUserId(this.$store.state.user.id).then(response => {
                    this.userItineraries = response.data;
                     this.isLoading = false;
                })
            })   
        });
    },
    data() {
        return {
            destination: {},
            isLoading: true,
            itineraries: [],
            userItineraries: [],
            isLiked: null,
            isClicked: false,
            selectedItinerary: null
            
        }
    },

    methods: {
     thumbsUp() {
        this.isLiked = true
        this.isClicked = true
    },

     thumbsDown() {
        this.isLiked = false
        this.isClicked = true
    },

    postToItinerary() {
        ItineraryServices.addToItinerary(this.destination.destinationId, this.selectedItinerary).then(() => {
        this.$router.push({name:"ItineraryDetail", params:{id:this.selectedItinerary}});
        })
     
    }


  } 
}

</script>

<style scoped>

h1 {
    display: flex;
    color: black;
    justify-content: center;
    margin-top: -10px;
    margin-bottom: 100px;
    font-family:Tahoma, Verdana, sans-serif
}

button {
    display: flex;
    justify-content: center;
    margin: auto;
}

select {
    display: flex;
    justify-content: center;
    margin: auto;
    margin-top: 10px;
}

h2 {
    display: flex;
    color: black;
    justify-content: center;
    margin: 20px;
    padding: 20px;
    grid-area: description;
}

li {
    color: black;
    padding: 8px;
}

.Hours {
    color: black; 
    grid-area: hours;
}

.center {
    display: block;
    margin-left: auto;
    margin-right: auto;
    width: 800px;
    border-radius: 10px;
}

a {
    display: flex;
    color: black;
    justify-content: center;
    margin: 30px;
    margin-top: -80px;
    font-size: 30px;
}
 
 a:hover {
     color: rgb(48, 196, 241)

 }

.rating {
  display: inline-block;
  width: 100%;
  text-align: center;
}

.like,
.dislike {
  display: inline-block;
  cursor: pointer;
  margin: 10px;
}

.dislike:hover,
.like:hover {
  color: #2EBDD1;
  transition: all .2s ease-in-out;
  transform: scale(1.1);
}

.active {
  color: #2EBDD1;
}

img {
    grid-area: image;
}

.both {
    display: grid;
    grid-template-columns: 1fr 1fr;
    grid-template-areas: 
    "description description"
    "image hours"
    
    ; 
}

.DestinationDetail {
    background: linear-gradient(to bottom, #ffffff 0%, #99ccff
100%);
}
</style>