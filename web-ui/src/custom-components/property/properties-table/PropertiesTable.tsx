import {DataTable} from "../../DataTable.tsx"
import {PropertyTableColumns} from "@/custom-components/property/properties-table/propertyTableColumns.tsx";
import {Property} from "@/types/Property.ts";
import {useFetchTableData} from "@/hooks/useFetchTableData.ts";


// export const PropertiesTable = () => {
//   const [ tableData ] = useFetchTableData<Property>(import.meta.env.VITE_PROPERTY_API_URL)
//
//   return (
//     <div className="container mx-auto py-10">
//       <DataTable columns={PropertyTableColumns} data={tableData} />
//     </div>
//   )
// }