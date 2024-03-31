import {FC} from "react";
import {usePropertyContext} from "../api/providers/PropertyProvider.tsx";
import {objectToArray} from "../utils/objectToArray.ts"

export const PropertiesList: FC = () => {
  const { data: properties, loading, error } = usePropertyContext();

  if (loading) return <div>loading</div>
  if (error) return <div>Error: {error.message}</div>
  if (!properties) return null

  properties.forEach(console.log)

  return (
    <div>
      <h1>Property List</h1>
      <ul>
        {properties.map(property => (
          <li key={property.id}>
            {objectToArray(property.location).join(" - ")} - ${property.price}
          </li>
        ))}
      </ul>
    </div>
  )
}