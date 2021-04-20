<template>
  <div>
    <div>
       <select v-if="destinations.length > 0" name="oneOption" id="itineraryList" v-model="start">
            <option value="">Starting Location</option>
            <option v-for="destination in destinations" :key="destination.destinationId" :value="destination.name">{{destination.name}}</option>
            </select>
       <select v-if="destinations.length > 0" name="oneOption" id="itineraryList" v-model="end">
            <option value="">Destination</option>
            <option v-for="destination in destinations" :key="destination.destinationId" :value="destination.name">{{destination.name}}</option>
            </select>     
    </div>
    <br>
    <GmapMap
      :center='center'
      :zoom='12'
      style='width:100%;  height: 400px;'
    >
     <DirectionsRenderer travelMode="DRIVING" :origin="origin" :destination="destionation"/>
      <GmapMarker
        :key="index"
        v-for="(m, index) in markers"
        :position="m.position"
        @click="center=m.position"
      />
    </GmapMap>
  </div>
</template>

<script>
import DirectionsRenderer from "../components/Directions.js"
export default {
  name: 'GoogleMap',
  components: {
    DirectionsRenderer
  },
  props: ["destinations"],
  data() {
    return {
      center: { lat: 41.499, lng: -81.694 },
      currentPlace: null,
      markers: [],
      places: [],
      waypoints: [],
      start:'',
      end: '',



    }
  },

   computed: {
    origin() {
      if (!this.start) return null;
      return { query: this.start };
    },
    destionation() {
      if (!this.end) return null;
      return { query: this.end };
    }
  },

  mounted() {
    //this.geolocate();
  },

  methods: {
    setPlace(place) {
      this.currentPlace = place;
    },
    addMarker() {
      if (this.currentPlace) {
        const marker = {
          lat: this.currentPlace.geometry.location.lat(),
          lng: this.currentPlace.geometry.location.lng(),
        };
        this.markers.push({ position: marker });
        this.places.push(this.currentPlace);
        this.center = marker;
        this.currentPlace = null;
      }
    },
    geolocate: function() {
      navigator.geolocation.getCurrentPosition(position => {
        this.center = {
          lat: position.coords.latitude,
          lng: position.coords.longitude,
        };
      });
    },
  },
};
</script>