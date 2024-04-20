import {useEffect, useRef, useState} from "react";
import axios from "../mocks/axiosConfig.ts";
import {AxiosResponse, AxiosError, AxiosRequestConfig} from "axios"

type FetchDataResult<T> = {
  data: T | null;
  loading: boolean;
  error: Error | null;
}

// lol use react query

export const useFetchData = <T>(url: string, params?: AxiosRequestConfig<T>): [FetchDataResult<T>, () => void] => {
  const [data, setData] = useState<T | null>(null);
  const [loading, setLoading] = useState<boolean>(true);
  const [error, setError] = useState<Error | null>(null);
  const initialRender = useRef(true)

  const fetchData = () => {
    console.log(`called fetchData url: ${url}`)
    setLoading(true)
    axios.get<T>(url, params)
      .then((response: AxiosResponse<T>) => {
        setData(response.data)
        setError(null)
      }).catch((error: AxiosError) => {
        setData(null)
        setError(error)
      }).finally(() => {
        setLoading(false)
      })
  }

  useEffect(() => {
    if (initialRender.current) initialRender.current = false
    else fetchData()
  }, [url])

  return [{ data, loading, error }, fetchData]
}