export type Property = {
  id: string;
  location: Location;
  price: number;
  publicTransport: PublicTransportDetails;
  addedOn: string;
  propertyType: PropertyType;
  tenure: Tenure;
  rooms: Rooms;
  size?: number;
  hasGarden?: boolean;
}

type Location = {
  road: string,
  region: string,
  city: string,
  postcode: string
}

type PublicTransportDetails = { stations: StationDetails[]; }
type StationDetails = {
  name: string;
  stationType: StationType;
  distanceFromProperty: number;
}
enum StationType { TRAIN, TRAM, BUS }

enum PropertyType { DETACHED, SEMI_DETACHED, TERRACED, BUNGALOW, FLAT }

enum Tenure { FREEHOLD, LEASEHOLD, SHARED_FREEHOLD }

type Rooms = {
  bedrooms: number;
  bathrooms: number;
  hasEnsuite: boolean;
}