package com.springboot.ranga.learn_webservices.helloworld.hateoas;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/places")
public class PlaceController {

    private Map<Long, Place> places = new HashMap<>();

    public PlaceController() {
        places.put(1L, new Place(1L, "Taj Mahal", "Agra, India",
                "A UNESCO World Heritage site built in 1632",
                "Constructed by Mughal emperor Shah Jahan in memory of his wife Mumtaz Mahal",
                "October to March"));
        places.put(2L, new Place(2L, "Red Fort", "Delhi, India",
                "Historic fort built in 1639",
                "Served as the main residence of Mughal emperors for nearly 200 years",
                "November to February"));
        places.put(3L, new Place(3L, "Gateway of India", "Mumbai, India",
                "Iconic arch monument built in 1924 overlooking the Arabian Sea",
                "Constructed to commemorate the landing of King George V and Queen Mary in 1911",
                "November to February"));

        places.put(4L, new Place(4L, "Qutub Minar", "Delhi, India",
                "World’s tallest brick minaret at 73 meters",
                "Built in 1193 by Qutb-ud-din Aibak, marking the beginning of Muslim rule in India",
                "October to March"));

        places.put(5L, new Place(5L, "Hawa Mahal", "Jaipur, India",
                "Palace of Winds with 953 small windows (jharokhas)",
                "Constructed in 1799 by Maharaja Sawai Pratap Singh for royal women to observe street festivals",
                "October to March"));

        places.put(6L, new Place(6L, "Charminar", "Hyderabad, India",
                "Historic mosque and monument with four grand arches",
                "Built in 1591 by Muhammad Quli Qutb Shah to commemorate the end of a plague",
                "November to February"));

        places.put(7L, new Place(7L, "Mysore Palace", "Mysore, India",
                "Magnificent Indo-Saracenic style palace",
                "Rebuilt in 1912 after the old wooden palace was destroyed by fire",
                "September to March"));

        places.put(8L, new Place(8L, "Golden Temple", "Amritsar, India",
                "Holiest shrine of Sikhism, known for its golden dome",
                "Originally built in 1581 by Guru Arjan Dev, later gilded with gold by Maharaja Ranjit Singh",
                "October to March"));

        places.put(9L, new Place(9L, "Sun Temple", "Konark, Odisha",
                "13th-century temple shaped like a colossal chariot",
                "Built in 1250 CE by King Narasimhadeva I, dedicated to the Sun God Surya",
                "October to February"));

        places.put(10L, new Place(10L, "Victoria Memorial", "Kolkata, India",
                "Marble building dedicated to Queen Victoria",
                "Constructed between 1906 and 1921 during British rule",
                "November to February"));
    }

    // ✅ List endpoint: summary only (no id, no self link)
    @GetMapping
    public CollectionModel<EntityModel<PlaceSummary>> getAllPlaces() {
        List<EntityModel<PlaceSummary>> placeResources = new ArrayList<>();

        for (Place place : places.values()) {
            PlaceSummary summary = new PlaceSummary(place.getName());

            EntityModel<PlaceSummary> resource = EntityModel.of(summary);

            // Add link to details
            resource.add(WebMvcLinkBuilder.linkTo(
                    WebMvcLinkBuilder.methodOn(PlaceController.class).getPlace(place.getId()))
                    .withRel("details"));

            placeResources.add(resource);
        }

        return CollectionModel.of(placeResources,
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(PlaceController.class).getAllPlaces())
                        .withRel("all-places"));
    }

    // ✅ Details endpoint: full info
    @GetMapping("/{id}")
    public EntityModel<Place> getPlace(@PathVariable Long id) {
        Place place = places.get(id);

        EntityModel<Place> resource = EntityModel.of(place);

        // Only link back to all places
        resource.add(WebMvcLinkBuilder.linkTo(
                WebMvcLinkBuilder.methodOn(PlaceController.class).getAllPlaces())
                .withRel("all-places"));

        return resource;
    }
}