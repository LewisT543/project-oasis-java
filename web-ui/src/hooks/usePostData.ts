import {useState} from "react";
import axios from "../mocks/axiosConfig.ts";

type PostData<T> = (data: T) => Promise<void>
type PostDataResult = {
  loading: boolean;
  error: Error | null;
}

export const usePostData = <T>(url: string): [PostDataResult, PostData<T>] => {
  const [ loading, setLoading ] = useState<boolean>(false)
  const [ error, setError ] = useState<Error | null>(null)

  const postDataFn = async (data: T) => {
    setLoading(true)
    return axios.post(url, data)
      .then(() => setError(null))
      .catch((err) => setError(err))
      .finally(() => setLoading(false))
  }

  return [{ loading, error }, postDataFn]
}