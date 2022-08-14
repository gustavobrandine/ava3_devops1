package br.com.school.aplicacao;
import br.com.school.aluno.Aluno;
import br.com.school.crud.AgendaDAO;
public class Main {

	public static void main(String[] args) {
		AgendaDAO agenda = new AgendaDAO(); 

		Aluno aluno = new Aluno (); 
		aluno.setNomeAluno("Gustavo Rafael Rodrigues Brandine");
		aluno.setIdade(15);
		aluno.setDisciplina("Banco de Dados");
		aluno.setTurma("C");
		aluno.setSerie("1");
		//Salvar aluno
		agenda.save(aluno);

		//Atualizar Aluno 
		Aluno updateAluno = new Aluno ();
		updateAluno.setNomeAluno("Gustavo R. R. Brandine");
		updateAluno.setIdade(19); 
		updateAluno.setSerie("1");
		updateAluno.setTurma("C"); 
		updateAluno.setDisciplina("Banco de dados III");
		updateAluno.setIdAluno(32); 		
		agenda.update(updateAluno);

		//Deletar aluno por id do aluno
		//agenda.deleteId(13);

		//Deletar aluno lista cadastrada
		//agenda.deleteList();

		System.out.println("----------  LISTA  ------------");
		for(Aluno c : agenda.getAlunos()) {
			System.out.println(
					"---------------------------------" 
							+ "\nAluno: "  + c.getNomeAluno() 
							+ "\nSérie: " + c.getSerie() + " - Turma: " + c.getTurma()
							+ "\nIdade : " + c.getIdade() + " anos" 
							+ "\nDisciplina: " + c.getDisciplina());

		}
		System.out.println("---------------------------------");

	}
}
