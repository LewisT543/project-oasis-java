export type ContextType<T> = {
  data: T[] | null;
  loading: boolean;
  error: Error | null;
}