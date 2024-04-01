import {Property, PropertyType, StationType, Tenure} from "@/types/Property.ts";

export const mockPropertyResponse: Property[] = [
  {
    "id": "660099bef094bc1c3bf3cdc8",
    "location": {
      "road": "mockroad",
      "region": "mockregion",
      "city": "mockcity",
      "postcode": "mockpostcode"
    },
    "price": 300000,
    "publicTransport": {
      "stations": [
        {
          "name": "mockStation1",
          "stationType": StationType.TRAIN,
          "distanceFromProperty": 1.2
        },
        {
          "name": "mockStation2",
          "stationType": StationType.BUS,
          "distanceFromProperty": 0.6
        }
      ]
    },
    "addedOn": "2024-03-24T21:23:10.052+00:00",
    "propertyType": PropertyType.SEMI_DETACHED,
    "tenure": Tenure.FREEHOLD,
    "rooms": {
      "bedrooms": 5,
      "bathrooms": 2,
      "hasEnsuite": false
    },
    "size": 2500,
    "hasGarden": true
  }
]