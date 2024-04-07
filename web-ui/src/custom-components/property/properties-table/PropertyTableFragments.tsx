import {
  DropdownMenu,
  DropdownMenuContent,
  DropdownMenuItem,
  DropdownMenuLabel,
  DropdownMenuSeparator,
  DropdownMenuTrigger
} from "@/components/ui/dropdown-menu.tsx";
import {Button} from "@/components/ui/button.tsx";
import {ArrowUpDown, MoreHorizontal} from "lucide-react";
import {Column, Row} from "@tanstack/react-table";
import {formatDTStringTo, formatNumber} from "@/utils/formatterFns.ts";
import {Location, Property, Rooms} from "@/types/Property.ts";
import {useModalPage} from "@/hooks/useModalPage.ts";

/*
  modal page/popup here comprised of all the following values:
    publicTransport: PublicTransportDetails;
    tenure: Tenure;
    size?: number;
    hasGarden?: boolean;
  */

export const PropertyTableRowDropdown = ({ property }: {property: Property}) => {
  const { isOpen, openModal, closeModal, toggleModal } = useModalPage()
  return (
    <>
      <DropdownMenu>
        <DropdownMenuTrigger asChild>
          <Button variant="ghost" className="h-8 w-8 p-0">
            <span className="sr-only">Open menu</span>
            <MoreHorizontal className="h-4 w-4" />
          </Button>
        </DropdownMenuTrigger>
        <DropdownMenuContent align="end">
          <DropdownMenuLabel>Actions</DropdownMenuLabel>
          <DropdownMenuItem onClick={() => navigator.clipboard.writeText(property.id)}>Copy property ID</DropdownMenuItem>
          <DropdownMenuSeparator />
          <DropdownMenuItem onClick={() => { console.log("isOpen: " + isOpen); toggleModal() } }>View full details</DropdownMenuItem>
          <DropdownMenuItem>Go to Suitability Search</DropdownMenuItem>
        </DropdownMenuContent>
      </DropdownMenu>
      {/*
        TODO: Add a Modal here for Full Property Details Popup (not sure if I can do this here or if it needs to be done on the sub-page level?
      */}
    </>
  )
}

export const PropertyTableSortedHeader = ({ column, headerName }: { column: Column<Property>, headerName: string }) => (
  <Button variant="ghost" onClick={() => column.toggleSorting(column.getIsSorted() === "asc")}>
    {headerName}
    <ArrowUpDown className="ml-2 h-4 w-4" />
  </Button>
)

export const PropertyTableNumberColumn = ({ row, colName }: { row: Row<Property>, colName: string }) => {
  const amount = parseFloat(row.getValue(colName))
  return <div className="text-right font-medium">{formatNumber(amount)}</div>
}

const ensuiteCaseMatch = (hasEnsuite: undefined | boolean): string => {
  switch (hasEnsuite) {
    case (hasEnsuite == undefined): return "?"
    case hasEnsuite: return "Yes"
    case !hasEnsuite: return "No"
    default: return "?"
  }
}

export const PropertyTableRoomsCell = ({ row }: { row: Row<Property> }) => {
  const { bedrooms, bathrooms, hasEnsuite }: Rooms = row.original.rooms
  const displayStr = `Bed: ${bedrooms}, Bath: ${bathrooms}, EnSuite: ${ensuiteCaseMatch(hasEnsuite)}`
  return <div className="w-[160px]">{displayStr}</div>
}

export const PropertyTableLocationCell = ({ row }: { row: Row<Property> }) => {
  const { road, city, region, postcode }: Location = row.original.location
  const displayStr = `${road}, ${city}, ${region} - ${postcode.toUpperCase()}`
  return <div className="w-[220px]">{displayStr}</div>
}

export const PropertyTableAddedOnCell = ({ row }: { row: Row<Property> }) => {
  const addedOn = formatDTStringTo(row.original.addedOn, "short-date")
  return <div className="w-[80px]" >{addedOn}</div>
}