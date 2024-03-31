import {useEffect, useState} from "react";
import axios from "../mocks/axiosConfig.ts";
import {AxiosResponse, AxiosError} from "axios"

type FetchDataResult<T> = {
  data: T | null;
  loading: boolean;
  error: Error | null;
}

export const useFetchData = <T>(url: string): FetchDataResult<T> => {
  const [data, setData] = useState<T | null>(null);
  const [loading, setLoading] = useState<boolean>(true);
  const [error, setError] = useState<Error | null>(null);

  useEffect(() => {
    axios.get<T>(url)
      .then((response: AxiosResponse<T>) => {
        setData(response.data)
      }).catch((error: AxiosError) => {
        setError(error)
      }).finally(() => {
        setLoading(false)
    })
    return () => {

    }
  }, [url])

  return { data, loading, error }
}