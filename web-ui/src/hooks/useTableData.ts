import {useEffect, useState} from "react";
import {useFetchData} from "@/hooks/useFetchData.ts";

export const useTableData = <T>(apiUrl: string): T[] => {
  const [ tableData, setTableData ] = useState<T[]>([])
  const { data } = useFetchData<T[]>(apiUrl)

  useEffect(() => {
    setTableData(data ?? [])
  }, [data])

  return tableData
}