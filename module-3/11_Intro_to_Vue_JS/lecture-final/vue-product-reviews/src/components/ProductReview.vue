<template>
  <div class="main">
      <h2>Product Reviews for {{ name }}</h2>
      <p class="description">{{ description }}</p>

      <div class="well-display">
          <div class="well">
              <span class="amount">{{ averageRating }}</span>
              Average Rating
           </div>
           <div class="well">
               <span class="amount">{{ numberOfOneStarReviews }}</span>
               1 Star Review{{ numberOfOneStarReviews === 1 ? '' : 's'}}
            </div>
      </div>

    <!-- The reviews -->
      <div class="review" 
        v-bind:class="{ favorited: review.favorited === true }"
        v-for="review in reviews" v-bind:key="review.reviewer">
          <h4>{{ review.reviewer }}</h4>
          <div class="rating">
            <img src="../assets/star.png" class="ratingStar" v-for="n in review.rating" 
                v-bind:key="n" v-bind:title="review.rating + ' Star Review ' + n"/>
            </div>
          <h3>{{ review.title }}</h3>
          <p>{{ review.review }}</p>
          <p>Favorited? <input type="checkbox" v-model="review.favorited"/></p>
        </div>
    </div>
</template>

<script>
export default {
    name: 'product-review',
    data() {
        return {
            name: 'Cigar Party For Dummies, Vol 2',
            description: 'Host and plan the perfect cigar party for all of your squirrelly friends.',
            reviews: [
                {
                reviewer: "Malcolm Gladwell",
                title: "What a book!",
                review:
                    "It certainly is a book. I mean, I can see that. Pages kept together with glue and there's writing on it, in some language.",
                rating: 3,
                favorited: false
                },
                {
                reviewer: "Tim Ferriss",
                title: "Had a cigar party started in less than 4 hours.",
                review:
                    "It should have been called the four hour cigar party. That's amazing. I have a new idea for muse because of this.",
                rating: 4,
                favorited: false
                },
                {
                reviewer: "Ramit Sethi",
                title: "What every new entrepreneurs needs. A door stop.",
                review:
                    "When I sell my courses, I'm always telling people that if a book costs less than $20, they should just buy it. If they only learn one thing from it, it was worth it. Wish I learned something from this book.",
                rating: 1,
                favorited: false
                },
                {
                reviewer: "Gary Vaynerchuk",
                title: "And I thought I could write",
                review:
                    "There are a lot of good, solid tips in this book. I don't want to ruin it, but prelighting all the cigars is worth the price of admission alone.",
                rating: 3,
                favorited: false
                }
            ]
        }
    },
    computed: {
        averageRating() {
            let sum = this.reviews.reduce((prevVal, curVal) => {
                return prevVal + curVal.rating;
            }, 0);
            return sum / this.reviews.length;
        },
        numberOfOneStarReviews() {
            // let count = 0;
            // this.reviews.forEach((review) => {
            //     if (review.rating === 1) {
            //         count++;
            //     }
            // });
            // return count;
            return this.countStars(1);
        },
        numberOfTwoStarReviews() {
            // let count = 0;
            // this.reviews.forEach((review) => {
            //     if (review.rating === 2) {
            //         count++;
            //     }
            // });
            // return count;
            return this.countStars(2);
        }
    },
    methods: {
        countStars(rating) {
            let count = 0;
            this.reviews.forEach((review) => {
                if (review.rating === rating) {
                    count++;
                }
            });
            return count;
        }
    }
}
</script>

<style scoped>
div.main {
    margin: 1rem 0;
}

div.favorited {
    background-color: lightsalmon;
}

div.main div.well-display {
    display: flex;
    justify-content: space-around;
}

div.main div.well-display div.well {
    display: inline-block;
    width: 15%;
    border: 1px black solid;
    border-radius: 6px;
    text-align: center;
    margin: 0.25rem;
}

div.main div.well-display div.well span.amount {
    color: darkslategray;
    display: block;
    font-size: 2.5rem;
}

div.main div.review {
    border: 1px black solid;
    border-radius: 6px;
    padding: 1rem;
    margin: 10px;
}

div.main div.review div.rating {
    height: 2rem;
    display: inline-block;
    vertical-align: top;
    margin: 0 0.5rem;
}

div.main div.review div.rating img {
    height: 100%;
}

div.main div.review p {
    margin: 20px;
}

div.main div.review h3 {
    display: inline-block;
}

div.main div.review h4 {
    font-size: 1rem;
}
</style>