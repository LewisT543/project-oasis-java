import {useEffect, useState} from "react";
import {useFetchData} from "@/hooks/useFetchData.ts";

export const useFetchTableData = <T>(apiUrl: string): [T[], () => void] => {
  const [ tableData, setTableData ] = useState<T[]>([])
  const [{ data }, fetchData] = useFetchData<T[]>(apiUrl)

  useEffect(() => {
    setTableData(data ?? [])
  }, [data])

  return [ tableData, fetchData ]
}