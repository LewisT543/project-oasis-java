
export const objectToArray = <T>(obj: Record<string, T>): T[] => obj == null ? logAndReturn(obj) : Object.values(obj);
const logAndReturn = <T>(obj: T): T[] => {
  console.log(`${obj} obj is null`)
  return [obj]
}