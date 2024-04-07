"use client"

import {ColumnDef} from "@tanstack/react-table"
import {ArrowUpDown, MoreHorizontal} from "lucide-react"
import {Payment} from "./PropertiesTable.tsx";
import {Button} from "@/components/ui/button"
import {
  DropdownMenu,
  DropdownMenuContent,
  DropdownMenuItem,
  DropdownMenuLabel,
  DropdownMenuSeparator,
  DropdownMenuTrigger,
} from "@/components/ui/dropdown-menu"
import {Property, PropertyType} from "@/types/Property.ts";
import {
  PropertyTableAddedOnCell,
  PropertyTableLocationCell,
  PropertyTableNumberColumn,
  PropertyTableRoomsCell,
  PropertyTableRowDropdown,
  PropertyTableSortedHeader
} from "@/custom-components/property/properties-table/PropertyTableFragments.tsx";
import {formatNumber, formatPropertyType} from "@/utils/formatterFns.ts";


const ExampleColumns: ColumnDef<Payment>[] = [
  {
    id: "actions",
    cell: ({ row }) => {
      const payment = row.original

      return (
        <DropdownMenu>
          <DropdownMenuTrigger asChild>
            <Button variant="ghost" className="h-8 w-8 p-0">
              <span className="sr-only">Open menu</span>
              <MoreHorizontal className="h-4 w-4" />
            </Button>
          </DropdownMenuTrigger>
          <DropdownMenuContent align="end">
            <DropdownMenuLabel>Actions</DropdownMenuLabel>
            <DropdownMenuItem
              onClick={() => navigator.clipboard.writeText(payment.id)}
            >
              Copy payment ID
            </DropdownMenuItem>
            <DropdownMenuSeparator />
            <DropdownMenuItem>View customer</DropdownMenuItem>
            <DropdownMenuItem>View payment details</DropdownMenuItem>
          </DropdownMenuContent>
        </DropdownMenu>
      )
    },
  },
  {
    accessorKey: "status",
    header: "Status",
  },
  {
    accessorKey: "email",
    header: ({ column }) => {
      return (
        <Button
          variant="ghost"
          onClick={() => column.toggleSorting(column.getIsSorted() === "asc")}
        >
          Email
          <ArrowUpDown className="ml-2 h-4 w-4" />
        </Button>
      )
    },
  },
  {
    accessorKey: "amount",
    header: () => <div className="text-right">Amount</div>,
    cell: ({ row }) => {
      const amount = parseFloat(row.getValue("amount"))
      return <div className="text-right font-medium">{formatNumber(amount)}</div>
    },
  },
]

export const PropertyTableColumns: ColumnDef<Property>[] = [
  {
    id: "actions",
    cell: ({ row }) => (<PropertyTableRowDropdown property={row.original}/>),
  },
  {
    accessorKey: "id",
    header: "ID",
  },
  {
    accessorKey: "price",
    header: "Price",
    cell: ({ row }) => (<PropertyTableNumberColumn row={row} colName="price" />)
  },
  {
    accessorKey: "location",
    header: ({ column }) => (<PropertyTableSortedHeader column={column} headerName="Location"/>),
    cell: ({ row }) => (<PropertyTableLocationCell row={row} />)
  },
  {
    accessorKey: "propertyType",
    header: ({ column }) => (<PropertyTableSortedHeader column={column} headerName="Type"/>),
    cell: ({ row }) => formatPropertyType(PropertyType[row.original.propertyType])
  },
  {
    accessorKey: "rooms",
    header: ({ column }) => (<PropertyTableSortedHeader column={column} headerName="Rooms"/>),
    cell: ({ row }) => (<PropertyTableRoomsCell row={row} />)
  },
  {
    accessorKey: "addedOn",
    header: "Date Added",
    cell: ({ row }) => (<PropertyTableAddedOnCell row={row} />),
  },
]
