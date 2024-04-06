import {useState} from "react";

export const useModalPage = () => {
  const [ isOpen, setIsOpen ] = useState<boolean>(false)
  const openModal = () => setIsOpen(true)
  const closeModal = () => setIsOpen(false)
  const toggleModal = () => isOpen ? closeModal() : openModal()
  return { isOpen, openModal, closeModal, toggleModal }
}