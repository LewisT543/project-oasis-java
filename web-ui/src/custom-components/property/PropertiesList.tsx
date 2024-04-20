import {FC} from "react";
import {objectToArray} from "@/utils/objectToArray.ts"
import {useFetchData} from "@/hooks/useFetchData.ts";
import {Property} from "@/types/Property.ts";
import {Button} from "@/components/ui/button.tsx";

export const PropertiesList: FC = () => {
  const [{ data: properties, loading, error }, fetchData] = useFetchData<Property[]>(import.meta.env.VITE_PROPERTY_API_URL)

  if (loading) return <div>loading</div>
  if (error) return <div>Error: {error.message}</div>
  if (!properties) return null

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
      <Button onClick={fetchData}>REFETCH </Button>
    </div>
  )
}