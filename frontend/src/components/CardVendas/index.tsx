import NotificationButton from '../NotificationButton';
import "react-datepicker/dist/react-datepicker.css";
import DatePicker from "react-datepicker";
import './styles.css';
import { useEffect, useState } from 'react';
import axios from 'axios';
import { BASE_URL } from '../../utils/request';
import { Venda } from '../../models/vendas';
function cardVendas() {

    /**Exercício */
    const max = new Date();
    //const min = new Date();
    const min = new Date(new Date().setDate(new Date().getDate() - 365));

    /**Estado para data mínima e estado para data máxima */
    const [minDate, setMinDate] = useState(min);
    const [maxDate, setMaxDate] = useState(max);

    const [vendas, setVenda] = useState<Venda[]>([])

    /**Uma função como primeiro argumento e uma lista como segundo argumento */
    useEffect(() => {
        /**Para testar */
        axios.get(`${BASE_URL}/vendas`).then(response => {
            setVenda(response.data.content);
        });
    }, [])

    return (
        <div className="dsmeta-card">
            <h2 className="dsmeta-sales-title">Vendas</h2>
            <div>
                <div className="dsmeta-form-control-container">
                    <DatePicker
                        selected={minDate}
                        onChange={(date: Date) => setMinDate(date)}
                        className="dsmeta-form-control"
                        dateFormat="dd/MM/yyyy"
                    />
                </div>
                <div className="dsmeta-form-control-container">
                    <DatePicker
                        selected={maxDate}
                        onChange={(date: Date) => setMaxDate(date)}
                        className="dsmeta-form-control"
                        dateFormat="dd/MM/yyyy"
                    />
                </div>
            </div>

            <div>
                <table className="dsmeta-sales-table">
                    <thead>
                        <tr>
                            <th className="show992">ID</th>
                            <th className="show576">Data</th>
                            <th>Vendedor</th>
                            <th className="show992">Visitas</th>
                            <th className="show992">Vendas</th>
                            <th>Total</th>
                            <th>Notificar</th>
                        </tr>
                    </thead>
                    <tbody>

                        {
                            /**Para cada venda da lista vendas */
                            vendas.map(venda => {
                                return (
                                    <tr key={venda.id}>
                                        <td className="show992">#{venda.id}</td>
                                        <td className="show576">{new Date(venda.data).toLocaleDateString()}</td>
                                        <td>{venda.nomeVendedor}</td>
                                        <td className="show992">{venda.visita}</td>
                                        <td className="show992">{venda.venda}</td>
                                        <td>R$ {venda.valor.toFixed(2)}</td>
                                        <td>
                                            <div className="dsmeta-red-btn-container">
                                                <NotificationButton />
                                            </div>
                                        </td>
                                    </tr>
                                )
                            })
                        }

                    </tbody>

                </table>
            </div>

        </div>
    )
}

export default cardVendas;