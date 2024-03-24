import {FC} from "react";
import {usePropertyContext} from "../api/PropertyProvider.tsx";
import {objectToArray} from "../utils/objectToArray.ts"

export const PropertiesList: FC = () => {
  const { properties, loading, error } = usePropertyContext();

  if (loading) return <div>loading</div>
  if (error) return <div>Error: {error}</div>
  if (!properties) return null

  return (
    <div>
      <h1>Property List</h1>
      <ul>
        {properties.map(property => (
          <li key={property.id}>
            {objectToArray(property.location)} - ${property.price}
          </li>
        ))}
      </ul>
    </div>
  )
}